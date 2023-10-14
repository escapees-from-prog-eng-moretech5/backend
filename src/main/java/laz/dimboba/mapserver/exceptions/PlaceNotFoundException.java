package laz.dimboba.mapserver.exceptions;

public class PlaceNotFoundException extends Exception{
    public PlaceNotFoundException(String message) {
        super(message);
    }
    public PlaceNotFoundException() {
        super();
    }
}
