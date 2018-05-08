package carenbb.com.hackathon.emotion.joton;

/**
 * Created by HP on 28-Mar-16.
 */
public class DataChildCareInfo {

    private String info;
    private String descriptionMain;
    private String description2name;
    private String description2;
    private String description3name;
    private String description3;
    private int imageResourceId;

    public static final DataChildCareInfo[] infos = {
            new DataChildCareInfo("শিশুর যত্ন ১",
                    "এটা শিশুর যত্ন পেজের ১ নং বর্বনা।এটা আরও বাড়ানো যাবে।\n এটা নতুন লাইন \n\n এটা স্পেস ওয়ালা নতুন লাইন",
                    "২নং বর্ননার টাইটেল",
                    "২নং বর্ননা এখানে আসবে ... জশফ কজসাদ  জক্সদ ফাসদ কজসধ ফহ সদজখ সদজক শদফজক্সাদফহ ",
                    "৩নং বুর্ননার টাইটেল",
                    "এই বত্তননা টি ডাটাচাইল্ডিইনফো ক্লাস থেকে লেখা হয়েছে।এই ক্লাস থেকেই এটাকে এডিত করা যাবে।এটা ডিটেইল লেয়াউটের ৩নং সেকশনে যোগ হবে "),

            new DataChildCareInfo("শিশুর যত্ন ২",
                    "এটা শিশুর যত্নএর ২নং পেজের নং বর্বনা।এটাতে সেকশন ২ ও ৩ নংকে সুক্ত করা হয়নি ",null,null,null,null)
    };

    private DataChildCareInfo(String info,String descriptionMain,String description2name,String description2,String description3name,String description3)
    {
        this.info=info;
        this.descriptionMain=descriptionMain;
        this.description2name=description2name;
        this.description2=description2;
        this.description3name=description3name;
        this.description3=description3;
    }
    public String getInfo() {
        return info;
    }

    public String getMainDescription(){
        return descriptionMain;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public boolean description2available()
    {
        if (description2name== null)
        {
            return false;
        }
        return true;
    }
    public String getDescription2name(){
        return description2name;
    }
    public String getDescription2(){
        return description2;
    }
    public boolean description3available()
    {
        if (description2name== null)
        {
            return false;
        }
        return true;
    }
    public String getDescription3name(){
        return description2name;
    }
    public String getDescription3(){
        return description2;
    }
    public String toString() {
        return this.info;
    }

}
