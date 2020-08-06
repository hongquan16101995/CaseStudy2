package Data.CreateData;

import Product.Laptop;
import Product.SmartPhone;
import Product.Tablet;
import ReadWriteFile.IOFile;

import java.util.ArrayList;

public class MainCreateData {
    public static void main(String[] args) {
//        CreateListOfDataProduct createListOfDataProduct = new CreateListOfDataProduct();
//        ArrayList<Laptop> dataLaptop = createListOfDataProduct.createDataLaptop();
//        ArrayList<SmartPhone> dataSmartphone = createListOfDataProduct.createDataSmartphone();
//        ArrayList<Tablet> dataTablet = createListOfDataProduct.createDataTablet();

        IOFile<Laptop> ioLaptop = new IOFile<>();
        IOFile<SmartPhone> ioSmartphone = new IOFile<>();
        IOFile<Tablet> ioTablet = new IOFile<>();

//        ioLaptop.writerFileData(dataLaptop, "FileData/laptop");
//        ioSmartphone.writerFileData(dataSmartphone, "FileData/smartphone");
//        ioTablet.writerFileData(dataTablet, "FileData/tablet");

        ArrayList<Laptop> dataLaptop = ioLaptop.readFileData("FileData/laptop");
        ArrayList<SmartPhone> dataSmartphone = ioSmartphone.readFileData("FileData/smartphone");
        ArrayList<Tablet> dataTablet = ioTablet.readFileData("FileData/tablet");
    }
}
