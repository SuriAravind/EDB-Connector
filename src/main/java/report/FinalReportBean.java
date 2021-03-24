package report;

import java.util.List;

/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:47 AM.
 */
public class FinalReportBean {
    private Long filesCount;
    private Long totalIngestedCount;
    private List<ReportBean> reportBeanList;
    private String startTime;
    private String endTime;
    private String totalProcessingTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime=startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime=endTime;
    }

    public String getTotalProcessingTime() {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime(String totalProcessingTime) {
        this.totalProcessingTime=totalProcessingTime;
    }

    public Long getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(Long filesCount) {
        this.filesCount=filesCount;
    }

    public List<ReportBean> getReportBeanList() {
        return reportBeanList;
    }

    public void setReportBeanList(List<ReportBean> reportBeanList) {
        this.reportBeanList=reportBeanList;
    }

    public Long getTotalIngestedCount() {
        return totalIngestedCount;
    }

    public void setTotalIngestedCount(Long totalIngestedCount) {
        this.totalIngestedCount=totalIngestedCount;
    }

    @Override
    public String toString() {
        return "FinalReportBean{" + "filesCount=" + filesCount + ", totalIngestedCount=" + totalIngestedCount + ", reportBeanList=" + reportBeanList + ", startTime='" + startTime + '\'' + ", endTime='" + endTime + '\'' + ", totalProcessingTime='" + totalProcessingTime + '\'' + '}';
    }
}
