package Data.CreateData;


import Data.Laptop.*;
import Data.SmartPhone.*;
import Data.Tablet.*;
import java.io.IOException;
import java.util.ArrayList;


public class CreateOfDataProduct {
    private ArrayList<String> idLaptop;
    private ArrayList<String> nameLaptop;
    private ArrayList<String> brandLaptop;
    private ArrayList<String> priceLaptop;
    private ArrayList<String> idSmartphone;
    private ArrayList<String> nameSmartphone;
    private ArrayList<String> brandSmartphone;
    private ArrayList<String> priceSmartphone;
    private ArrayList<String> idTablet;
    private ArrayList<String> nameTablet;
    private ArrayList<String> brandTablet;
    private ArrayList<String> priceTablet;


    public void setAll() {
        setIdLaptop();
        setIdSmartphone();
        setIdTablet();
        setBrandLaptop();
        setBrandSmartphone();
        setBrandTablet();
        setNameLaptop();
        setNameSmartphone();
        setNameTablet();
        setPriceLaptop();
        setPriceSmartphone();
        setPriceTablet();
    }


    public ArrayList<String> getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop() {
        try {
            idLaptop = new DataIdOfLaptop().createDataId(new CreateDataOfLaptop().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getNameLaptop() {
        return nameLaptop;
    }

    public void setNameLaptop() {
        try {
            nameLaptop = new DataNameOfLaptop().createDataName(new CreateDataOfLaptop().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getBrandLaptop() {
        return brandLaptop;
    }

    public void setBrandLaptop() {
        try {
            brandLaptop = new DataBrandOfLaptop().createDataBrand(new CreateDataOfLaptop().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getPriceLaptop() {
        return priceLaptop;
    }

    public void setPriceLaptop() {
        try {
            priceLaptop = new DataPriceOfLaptop().createDataPrice(new CreateDataOfLaptop().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getIdSmartphone() {
        return idSmartphone;
    }

    public void setIdSmartphone() {
        try {
            idSmartphone = new DataIdOfSmartphone().createDataId(new CreateDataOfSmartphone().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getNameSmartphone() {
        return nameSmartphone;
    }

    public void setNameSmartphone() {
        try {
            nameSmartphone = new DataNameOfSmartphone().createDataName(new CreateDataOfSmartphone().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getBrandSmartphone() {
        return brandSmartphone;
    }

    public void setBrandSmartphone() {
        try {
            brandSmartphone = new DataBrandOfSmartphone().createDataBrand(new CreateDataOfSmartphone().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getPriceSmartphone() {
        return priceSmartphone;
    }

    public void setPriceSmartphone() {
        try {
            priceSmartphone = new DataPriceOfSmartphone().createDataPrice(new CreateDataOfSmartphone().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getIdTablet() {
        return idTablet;
    }

    public void setIdTablet() {
        try {
            idTablet = new DataIdOfTablet().createDataId(new CreateDataOfTablet().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getNameTablet() {
        return nameTablet;
    }

    public void setNameTablet() {
        try {
            nameTablet = new DataNameOfTablet().createDataName(new CreateDataOfTablet().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getBrandTablet() {
        return brandTablet;
    }

    public void setBrandTablet() {
        try {
            brandTablet = new DataBrandOfTablet().createDataBrand(new CreateDataOfTablet().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getPriceTablet() {
        return priceTablet;
    }

    public void setPriceTablet() {
        try {
            priceTablet = new DataPriceOfTablet().createDataPrice(new CreateDataOfTablet().createData());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
