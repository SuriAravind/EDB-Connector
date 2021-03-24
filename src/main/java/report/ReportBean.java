package report;

/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:45 AM.
 */
public class ReportBean {

    private String fileName;
    private Long ingestionCount;
    private Long totalFileCount;
    private String processingTime;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName=fileName;
    }

    public Long getIngestionCount() {
        return ingestionCount;
    }

    public void setIngestionCount(Long ingestionCount) {
        this.ingestionCount=ingestionCount;
    }

    public Long getTotalFileCount() {
        return totalFileCount;
    }

    public void setTotalFileCount(Long totalFileCount) {
        this.totalFileCount=totalFileCount;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime=processingTime;
    }

    @Override
    public String toString() {
        return "ReportBean{" + "fileName='" + fileName + '\'' + ", ingestionCount=" + ingestionCount + ", totalFileCount=" + totalFileCount + ", processingTime='" + processingTime + '\'' + '}';
    }
}
