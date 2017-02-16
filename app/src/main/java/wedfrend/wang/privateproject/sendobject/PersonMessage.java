package wedfrend.wang.privateproject.sendobject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by welive on 2017/2/16.
 */




public class PersonMessage implements Parcelable {

    private String name;

    private int age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        //将需要的只进行写出，调用 Parcel的writeXxx()方法
        //需要注意数据类型要一至
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);

    }

    public static final Parcelable.Creator<PersonMessage> CREATOR = new Parcelable.Creator<PersonMessage>(){
        @Override
        public PersonMessage createFromParcel(Parcel source) {
            //将需要的值读出来
            //需要注意的是读取的时候相应的顺序需要和写出的顺序一致
            PersonMessage personMessage = new PersonMessage();
            personMessage.name = source.readString();
            personMessage.age = source.readInt();
            personMessage.address = source.readString();
            return personMessage;
        }

        @Override
        public PersonMessage[] newArray(int size) {
            return new PersonMessage[size];
        }
    };


}
