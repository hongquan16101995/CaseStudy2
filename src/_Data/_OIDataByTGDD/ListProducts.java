package _Data._OIDataByTGDD;

import _Data.CreateData.CreateListOfDataProduct;
import _Product.Laptop;
import _Product.SmartPhone;
import _Product.Tablet;
import _ReadWriteFile.IOFile;
import java.util.ArrayList;

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
}
