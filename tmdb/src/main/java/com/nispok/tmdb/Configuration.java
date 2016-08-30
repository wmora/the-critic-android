package com.nispok.tmdb;

import java.util.List;

public final class Configuration {

    private ImageConfiguration images;
    private List<String> changeKeys;

    public ImageConfiguration getImages() {
        return images;
    }

    public void setImages(ImageConfiguration images) {
        this.images = images;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

    public void setChangeKeys(List<String> changeKeys) {
        this.changeKeys = changeKeys;
    }
}
