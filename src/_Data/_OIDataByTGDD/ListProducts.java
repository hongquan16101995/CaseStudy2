package _Data._OIDataByTGDD;

import _Data.CreateData.CreateListOfDataProduct;
import _Product.Laptop;
import _Product.Product;
import _Product.SmartPhone;
import _Product.Tablet;
import _ReadWriteFile.IOFile;
import java.util.ArrayList;
import java.util.Iterator;

public class ListProducts {
    private final IOFile<Laptop> ioLaptop;
    private final IOFile<SmartPhone> ioSmartphone;
    private final IOFile<Tablet> ioTablet;
    private final CreateListOfDataProduct createListOfDataProduct;
    private final String PATHNAME_OF_LAPTOP = "FileData/laptop";
    private final String PATHNAME_OF_SMARTPHONE = "FileData/smartphone";
    private final String PATHNAME_OF_TABLET = "FileData/tablet";

    public ListProducts() {
        ioLaptop = new IOFile<>();
        ioSmartphone = new IOFile<>();
        ioTablet = new IOFile<>();
        createListOfDataProduct = new CreateListOfDataProduct();
    }

    public void setListLaptop() {
        ArrayList<Laptop> dataLaptop = createListOfDataProduct.createDataLaptop();
        ioLaptop.writerFileData(dataLaptop, PATHNAME_OF_LAPTOP);
    }

    public void setListSmartphone() {
        ArrayList<SmartPhone> dataSmartphone = createListOfDataProduct.createDataSmartphone();
        ioSmartphone.writerFileData(dataSmartphone, PATHNAME_OF_SMARTPHONE);
    }

    public void setListTablet() {
        ArrayList<Tablet> dataTablet = createListOfDataProduct.createDataTablet();
        ioTablet.writerFileData(dataTablet, PATHNAME_OF_TABLET);
    }


    public ArrayList<Laptop> getListLaptop() {
        return ioLaptop.readFileData(PATHNAME_OF_LAPTOP);
    }

    public ArrayList<SmartPhone> getListSmartphone() {
        return ioSmartphone.readFileData(PATHNAME_OF_SMARTPHONE);
    }

    public ArrayList<Tablet> getListTablet() {
        return ioTablet.readFileData(PATHNAME_OF_TABLET);
    }

    public boolean checkFile() {
        if (getListLaptop() == null || getListTablet() == null || getListSmartphone() == null) {
            return true;
        }
        ArrayList<Laptop> list = getListLaptop();
        ArrayList<SmartPhone> list1 = getListSmartphone();
        ArrayList<Tablet> list2 = getListTablet();
        Iterator<Laptop> iterator = list.iterator();
        Iterator<SmartPhone> iterator1 = list1.iterator();
        Iterator<Tablet> iterator2 = list2.iterator();
        return (!iterator.hasNext() || !iterator1.hasNext() || !iterator2.hasNext());
    }
}
