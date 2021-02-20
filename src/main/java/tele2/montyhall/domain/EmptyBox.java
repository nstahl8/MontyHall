package tele2.montyhall.domain;

import tele2.montyhall.interfaces.Box;

public class EmptyBox implements Box {
    public Boolean hasPrice() {
        return false;
    }
}
