package Service.ModulsService.family;

import java.io.*;

public interface SaveAndLoad<H extends LivingBeing<H>, F extends Tree<H, F>> {
    abstract void save(F obj) throws IOException;
    abstract public F load() throws IOException, ClassNotFoundException;
}
