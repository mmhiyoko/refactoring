package refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
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
}
