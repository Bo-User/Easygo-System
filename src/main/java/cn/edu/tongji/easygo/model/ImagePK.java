package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ImagePK implements Serializable {
    private long imageId;
    private String imageUrl;
    private Integer imageType;

    @Id
    @Column(name = "image_id")
    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    @Id
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Id
    @Column(name = "image_type")
    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagePK imagePK = (ImagePK) o;
        return imageId == imagePK.imageId &&
                Objects.equals(imageUrl, imagePK.imageUrl) &&
                Objects.equals(imageType, imagePK.imageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imageUrl, imageType);
    }

    public ImagePK(long imageId, String imageUrl, Integer imageType) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }

    public ImagePK() {
    }
}
