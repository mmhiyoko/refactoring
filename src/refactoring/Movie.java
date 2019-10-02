package refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch(arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Invalid price code");
        }
    }

    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRentaled) {
        double result = 0.0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRentaled > 2) {
                    result  += (daysRentaled- 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRentaled * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRentaled > 3) {
                    result += (daysRentaled - 3) * 1.5;
                }
                break;
        }

        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1)
            return 2;
        else
            return 1;
    }
}
