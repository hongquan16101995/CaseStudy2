package _Data._OIDataByTGDD;

import _Data.CreateData.CreateListOfDataProduct;
import _Product.Laptop;
import _Product.SmartPhone;
import _Product.Tablet;
import _ReadWriteFile.IOFile;

import java.util.ArrayList;

public class ListProducts {
    private IOFile<Laptop> ioLaptop;
    private IOFile<SmartPhone> ioSmartphone;
    private IOFile<Tablet> ioTablet;
    private CreateListOfDataProduct createListOfDataProduct;

    public ListProducts() {
        ioLaptop = new IOFile<>();
        ioSmartphone = new IOFile<>();
        ioTablet = new IOFile<>();
        createListOfDataProduct = new CreateListOfDataProduct();
    }

    public void setListLaptop() {
        ArrayList<Laptop> dataLaptop = createListOfDataProduct.createDataLaptop();
        ioLaptop.writerFileData(dataLaptop, "FileData/laptop");
    }

    public void setListSmartphone() {
        ArrayList<SmartPhone> dataSmartphone = createListOfDataProduct.createDataSmartphone();
        ioSmartphone.writerFileData(dataSmartphone, "FileData/smartphone");
    }

    public void setListTablet() {
        ArrayList<Tablet> dataTablet = createListOfDataProduct.createDataTablet();
        ioTablet.writerFileData(dataTablet, "FileData/tablet");
    }

    public ArrayList<Laptop> getListLaptop() {
        return ioLaptop.readFileData("FileData/laptop");
    }

    public ArrayList<SmartPhone> getListSmartphone() {
        return ioSmartphone.readFileData("FileData/smartphone");
    }

    public ArrayList<Tablet> getListTablet() {
        return ioTablet.readFileData("FileData/tablet");
    }
}
