package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "image", schema = "easygo", catalog = "")
@IdClass(ImagePK.class)
public class Image {
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
        Image image = (Image) o;
        return imageId == image.imageId &&
                Objects.equals(imageUrl, image.imageUrl) &&
                Objects.equals(imageType, image.imageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imageUrl, imageType);
    }

    public Image(long imageId, String imageUrl, Integer imageType) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }

    public Image() {
    }
}