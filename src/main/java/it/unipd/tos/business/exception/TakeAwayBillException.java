////////////////////////////////////////////////////////////////////
// EMANUELE CISOTTO 1161514
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public TakeAwayBillException(String message) {
        errorMessage = message;
    }
}
