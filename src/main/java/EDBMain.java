import connection.EDBConnectionEstablisher;
import exception.EDBException;
import loader.EDBCopyLoader;
import report.FinalReportBean;
import utils.Utility;

import java.time.LocalDateTime;

/**
 * Created by Suriyanarayanan K
 * on 04/03/21 2:00 PM.
 */

public class EDBMain {
    public static void main(String[] args) {


        FinalReportBean finalReportBean=new FinalReportBean();
        LocalDateTime startTime=LocalDateTime.parse(Utility.currentTimeString(), Utility.formatter);
        finalReportBean.setStartTime(startTime.toString());
        String filesDirectory="/Users/apple/Documents/Archon3.1/archon-edb-postgress/testBlob";
        String tableName="test_blob";
        EDBConnectionEstablisher edbConnectionEstablisher=new EDBConnectionEstablisher();
        try {
            edbConnectionEstablisher.createConnection();
            EDBCopyLoader edbCopyLoader=new EDBCopyLoader(edbConnectionEstablisher.createConnection(),finalReportBean);
            edbCopyLoader.ingestCsvDataIntoDb(filesDirectory,tableName);
        } catch (EDBException e) {
            e.printStackTrace();
        }
        LocalDateTime endTime=LocalDateTime.parse(Utility.currentTimeString(), Utility.formatter);
        finalReportBean.setEndTime(endTime.toString());
        finalReportBean.setTotalProcessingTime(Utility.timeDiff(startTime,endTime));
        System.out.println(finalReportBean.toString());
    }

}
