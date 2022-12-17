package Lesson24;

class HeaderInfo {
    static final String timeStampHeader = "timestamp", closePriceHeader = "close";

    private int timeStampPosition = -1;
    private int closePricePosition = -1;

    public HeaderInfo() {
    }

    public HeaderInfo(String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            String curHeader = headers[i];
            switch (curHeader.toLowerCase()) {
                case timeStampHeader: {
                    this.timeStampPosition = i;
                    break;
                }
                case closePriceHeader: {
                    this.closePricePosition = i;
                    break;
                }
            }
        }
        if (this.timeStampPosition == -1) {
            throw new RuntimeException("TimeStamp header not found");
        }
        if (this.closePricePosition == -1) {
            throw new RuntimeException("close header not found");
        }
    }

    public int getTimeStampPosition() {
        return timeStampPosition;
    }

    public void setTimeStampPosition(int timeStampPosition) {
        this.timeStampPosition = timeStampPosition;
    }

    public int getClosePricePosition() {
        return closePricePosition;
    }

    public void setClosePricePosition(int closePricePosition) {
        this.closePricePosition = closePricePosition;
    }

}
