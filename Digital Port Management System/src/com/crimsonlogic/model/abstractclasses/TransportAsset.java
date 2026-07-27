package com.crimsonlogic.model.abstractclasses;

import java.util.Objects;

public abstract class TransportAsset {
    private String assetId;
    private String assetName;
    private String assetStatus;

    public TransportAsset() {
    }

    public TransportAsset(String assetId, String assetName, String assetStatus) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetStatus = assetStatus;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    @Override
    public String toString() {
        return "\n" +
                "Id= " + assetId +
                "\nName= " + assetName +
                "\nStatus= " + assetStatus +
                " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportAsset that = (TransportAsset) o;
        return Objects.equals(assetId, that.assetId) && Objects.equals(assetName, that.assetName) && Objects.equals(assetStatus, that.assetStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId, assetName, assetStatus);
    }
}
