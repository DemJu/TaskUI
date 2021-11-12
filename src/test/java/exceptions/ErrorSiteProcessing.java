package exceptions;

public class ErrorSiteProcessing {

    public static String basketNotEmpty(Integer count) throws CheckingSiteResults {
        if (count > 0) {
            return "The product has been added to the cart";
        } else {
            throw new CheckingSiteResults("The product has not been added to the cart");
        }
    }

    public static String basketEmpty(String empty) throws CheckingSiteResults {
        if (empty.equals("(empty)")) {
            return "There are no products in the basket";
        } else {
            throw new CheckingSiteResults("There are products in the basket");
        }
    }

    public static String productСart(Integer count, Integer from) throws CheckingSiteResults {
        if (count == from) {
            return "The quantity of the product corresponds to the selected one";
        } else {
            throw new CheckingSiteResults("The quantity of the product is " + String.valueOf(count) + ", but it should be " + String.valueOf(from));
        }
    }
}
