package loader;

import com.edb.copy.CopyManager;
import com.edb.core.BaseConnection;
import exception.EDBException;
import report.FinalReportBean;
import report.ReportBean;
import utils.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:27 AM.
 */

public class EDBCopyLoader {

    protected  Connection edbConnection;

private FinalReportBean finalReportBean;
    public EDBCopyLoader(Connection connection ,FinalReportBean finalReportBean ){
        this.edbConnection=connection;
        this.finalReportBean=finalReportBean;
    }
    public Long ingestCsvDataIntoDb(String fileDirectory,String tableName) throws EDBException {


        Long ingestedCount=0l;
        List<File> fileList =null;
        List<ReportBean> reportBeanList=new ArrayList<>();
        try {
            fileList=Files.list(Paths.get(fileDirectory))
                    .filter(file->file.toFile().getName().endsWith(".csv"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            finalReportBean.setFilesCount(fileList.stream().count());
            for (File file : fileList) {
                LocalDateTime startTime= LocalDateTime.parse(Utility.currentTimeString(), Utility.formatter);

                ReportBean reportBean=new ReportBean();
                reportBean.setFileName(file.getName());
                reportBean.setTotalFileCount(0l);

                long temporaryCount=new CopyManager((BaseConnection) this.edbConnection).copyIn("COPY "+tableName+" FROM STDIN (FORMAT csv,DELIMITER ',') " ,
                                                                                                new FileInputStream(file.getAbsolutePath()), 4096);

                ingestedCount+=temporaryCount;
                reportBean.setIngestionCount(temporaryCount);
                LocalDateTime endTime= LocalDateTime.parse(Utility.currentTimeString(), Utility.formatter);
                reportBean.setProcessingTime(Utility.timeDiff(startTime,endTime));
                reportBeanList.add(reportBean);
            }
            finalReportBean.setReportBeanList(reportBeanList);
            finalReportBean.setTotalIngestedCount(ingestedCount);
        } catch (IOException | SQLException exception) {
            throw  new EDBException(exception.getMessage());
        }
        return ingestedCount;
    }



}
