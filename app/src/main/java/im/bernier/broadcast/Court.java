package im.bernier.broadcast;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by michaelbernier on 15-08-07.
 */
public class Court implements Parcelable{
    private String name = "";
    private String objectId = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{name, objectId});
    }

    public static final Parcelable.Creator<Court> CREATOR = new Parcelable.Creator<Court>() {
        public Court createFromParcel(Parcel in) {
            return new Court(in);
        }

        public Court[] newArray(int size) {
            return new Court[size];
        }
    };

    public Court() {

    }

    private Court(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        name = data[0];
        objectId = data[1];
    }
}
