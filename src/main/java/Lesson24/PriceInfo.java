package Lesson24;

class PriceInfo implements Comparable {
    private String TimeStamp;
    private float price;

    public PriceInfo(String[] lineData, HeaderInfo headerInfo) {
        this.price = Float.parseFloat(lineData[headerInfo.getClosePricePosition()]);
        this.TimeStamp = lineData[headerInfo.getTimeStampPosition()];
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.TimeStamp = timeStamp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == getClass()) {
            return (int) (this.getPrice() - ((PriceInfo) o).getPrice());
        } else return -1;
    }
}
