package Mabayahomeexam.model;

import java.util.UUID;

/**
 * This class represents the Campaign entity.
 * A Campaign entity contains:
 * 1. a name
 * 2. a bid - the price the seller is willing to pay for advertisement.
 * 3. a status - active at default(stating if the campaign is active or not).
 * 4. a seller id (a unique id).
 */
public class Campaign {

    private String name;
    private double bid;
    private String status;
    private UUID sellerID;

    /**
     * constructor
     * @param name
     * @param bid
     * @param sellerId
     */
    public Campaign(String name, double bid, UUID sellerId) {
        this.name = name;
        this.bid = bid;
        this.status = "ACTIVE";
        this.sellerID = sellerId;
    }

    /**
     * return the campaign's name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the campaign's name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return the campaign's bid.
     * @return
     */
    public double getCampaignBid() {
        return bid;
    }

    /**
     * set the campaign's bid.
     * @param bid
     */
    public void getCampaignBid(double bid) {
        this.bid = bid;
    }

    /**
     * return the campaign's status.
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * set the campaign's status.
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * return the campaign seller's id.
     * @return
     */
    public UUID getSellerID() {
        return sellerID;
    }

    /**
     * set the campaign seller's id.
     * @param sellerID
     */
    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }
}