package Mabayahomeexam.testModules;

import Mabayahomeexam.service.ServiceCenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.UUID;

/**
 * This class is responsible for parsing a file with the information of the campaigns, their names,
 * bids, and sellers.
 */
public class CampaignParser {

    private ServiceCenter serviceCenter;

    /**
     * constructor
     * @param serviceCenter
     */
    public CampaignParser(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    /**
     * The method receives a file, and parses it:
     * in every line there is a product and all its features.
     * the method adds every parsed product (in every new line) to a list of
     * products and returns it.
     * @param file
     * @return
     */

    /**
     * The method receives a file, and parses it:
     * in every line there is a campaign and all its features.
     * the method calls parseCampaign to create the campaigns in every line.
     * @param file
     */
    public void generateCampaigns(File file){

        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String str;
            String splitStr[];

            //read the file, line by line. line format: name: ""; bid: ""; seller: ""
            while ((str = buff.readLine()) != null){
                //str in the new line. split it by the separator.
                splitStr = str.split("; ");
                //now in splitStr are the value of the campaign. create the campaign.
                parseCampaign(splitStr);
            }

            buff.close();
        } catch (Exception e) {
            System.out.println("error in file reading");
        }
    }

    /**
     * The method creates a campaign according to its features.
     * @param campaignFeatures
     */
    private void parseCampaign(String campaignFeatures[]){
        String splitStr[];
        //product attributes
        String name = "";
        double bid = 0;
        UUID sellerID = null;

        //iterate over the features.
        for (String val: campaignFeatures){
            splitStr = val.split(": ");
            switch (splitStr[0]){
                case "name":
                    name = splitStr[1];
                    break;
                case "bid":
                    bid = Double.parseDouble(splitStr[1]);
                    break;
                case "seller":
                    sellerID = UUID.fromString(splitStr[1]);
                    break;
                default:
                    break;
            }
        }
        //create the campaign. the service center will add the campaign to the dao.
        serviceCenter.createCampaign(name, bid, sellerID);
    }
}
