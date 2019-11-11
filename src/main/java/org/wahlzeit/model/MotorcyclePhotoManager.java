package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

import java.util.logging.Logger;

public class MotorcyclePhotoManager extends PhotoManager {

    private static final Logger log = Logger.getLogger(MotorcyclePhotoManager.class.getName());

    public static void initialize() {
        getInstance();
    }

    public static MotorcyclePhotoManager getInstance() {
        if(instance==null){
            instance = new MotorcyclePhotoManager();
        }
        if(!(instance instanceof MotorcyclePhotoManager))
            throw new IllegalStateException("Default PhotoManager used");
        return (MotorcyclePhotoManager)instance;
    }

    @Override
    public MotorcyclePhoto getPhoto(String id) {
        return getPhoto(PhotoId.getIdFromString(id));
    }

    @Override
    public MotorcyclePhoto getPhoto(PhotoId id) {
        return getPhotoFromId(id);
    }

    @Override
    public MotorcyclePhoto getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        MotorcyclePhoto result = (MotorcyclePhoto)doGetPhotoFromId(id);

        if (result == null) {
            result = MotorcyclePhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;
    }

    @Override
    public MotorcyclePhoto getVisiblePhoto(PhotoFilter filter) {
        return (MotorcyclePhoto)super.getVisiblePhoto(filter);
    }

    @Override
    public MotorcyclePhoto createPhoto(String filename, Image uploadedImage) throws Exception {
        return (MotorcyclePhoto)super.createPhoto(filename, uploadedImage);
    }
}
