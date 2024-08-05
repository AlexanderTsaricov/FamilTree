package Service.ModulsService.family;

public interface Tree<H, F> {
    void addHuman(H obj);
    H geYoungestHuman ();
    H getOldestHuman ();
}
