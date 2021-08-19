package com.example.hero;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class basic  implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("powerstats")
    @Expose
    private Powerstats powerstats;
    @SerializedName("appearance")
    @Expose
    private Appearance appearance;
    @SerializedName("biography")
    @Expose
    private Biography biography;
    @SerializedName("work")
    @Expose
    private Work work;
    @SerializedName("connections")
    @Expose
    private Connections connections;
    @SerializedName("images")
    @Expose
    private mImages images;

    public Work getWork() {
        return work;
    }

    public Connections getConnections() {
        return connections;
    }

    public mImages getImages() {
        return images;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public Biography getBiography() {
        return biography;
    }

    public Powerstats getPowerstats() {
        return powerstats;
    }

    protected basic(Parcel in) {
        this.powerstats =in.readParcelable(Powerstats.class.getClassLoader());
        this.appearance = in.readParcelable(Appearance.class.getClassLoader());
        this.biography = in.readParcelable(Biography.class.getClassLoader());
        this.work = in.readParcelable(Work.class.getClassLoader());
        this.connections = in.readParcelable(Connections.class.getClassLoader());
        this.images = in.readParcelable(mImages.class.getClassLoader());

        id = in.readString();
        name = in.readString();
        slug = in.readString();
    }

    public static final Creator<basic> CREATOR = new Creator<basic>() {
        @Override
        public basic createFromParcel(Parcel in) {
            return new basic(in);
        }

        @Override
        public basic[] newArray(int size) {
            return new basic[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(powerstats,flags);
        dest.writeParcelable(appearance,flags);
        dest.writeParcelable(biography,flags);
        dest.writeParcelable(work,flags);
        dest.writeParcelable(connections,flags);
        dest.writeParcelable(images,flags);

        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(slug);

    }

    public static class Powerstats implements Parcelable{
        @SerializedName("intelligence")
        @Expose
        private String intelligence;
        @SerializedName("strength")
        @Expose
        private String strength;
        @SerializedName("speed")
        @Expose
        private String speed;
        @SerializedName("durability")
        @Expose
        private String durability;
        @SerializedName("power")
        @Expose
        private String power;
        @SerializedName("combat")
        @Expose
        private String combat;

        protected Powerstats(Parcel in) {
            intelligence = in.readString();
            strength = in.readString();
            speed = in.readString();
            durability = in.readString();
            power = in.readString();
            combat = in.readString();
        }

        public static final Creator<Powerstats> CREATOR = new Creator<Powerstats>() {
            @Override
            public Powerstats createFromParcel(Parcel in) {
                return new Powerstats(in);
            }

            @Override
            public Powerstats[] newArray(int size) {
                return new Powerstats[size];
            }
        };

        public String getIntelligence() {
            return intelligence;
        }

        public String getStrength() {
            return strength;
        }

        public String getSpeed() {
            return speed;
        }

        public String getDurability() {
            return durability;
        }

        public String getPower() {
            return power;
        }

        public String getCombat() {
            return combat;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(intelligence);
            dest.writeString(strength);
            dest.writeString(speed);
            dest.writeString(durability);
            dest.writeString(power);
            dest.writeString(combat);
        }
    }

    public static class Appearance implements Parcelable{
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("race")
        @Expose
        private String race;
        @SerializedName("height")
        @Expose
        private List<String> height;
        @SerializedName("weight")
        @Expose
        private List<String> weight;
        @SerializedName("eyeColor")
        @Expose
        private String eyeColor;
        @SerializedName("hairColor")
        @Expose
        private String hairColor;

        protected Appearance(Parcel in) {
            gender = in.readString();
            race = in.readString();
            height = in.createStringArrayList();
            weight = in.createStringArrayList();
            eyeColor = in.readString();
            hairColor = in.readString();
        }

        public static final Creator<Appearance> CREATOR = new Creator<Appearance>() {
            @Override
            public Appearance createFromParcel(Parcel in) {
                return new Appearance(in);
            }

            @Override
            public Appearance[] newArray(int size) {
                return new Appearance[size];
            }
        };

        public String getGender() {
            return gender;
        }

        public String getRace() {
            return race;
        }

        public List<String> getHeight() {
            return height;
        }

        public List<String> getWeight() {
            return weight;
        }

        public String getEyeColor() {
            return eyeColor;
        }

        public String getHairColor() {
            return hairColor;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(gender);
            dest.writeString(race);
            dest.writeStringList(height);
            dest.writeStringList(weight);
            dest.writeString(eyeColor);
            dest.writeString(hairColor);
        }
    }
    public static class Biography implements Parcelable{

        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("alterEgos")
        @Expose
        private String alterEgos;
        @SerializedName("aliases")
        @Expose
        private List<String>aliases;
        @SerializedName("placeOfBirth")
        @Expose
        private String placeOfBirth;
        @SerializedName("firstAppearance")
        @Expose
        private String firstAppearance;
        @SerializedName("publisher")
        @Expose
        private String publisher;
        @SerializedName("alignment")
        @Expose
        private String alignment;

        protected Biography(Parcel in) {
            fullName = in.readString();
            alterEgos = in.readString();
            aliases = in.createStringArrayList();
            placeOfBirth = in.readString();
            firstAppearance = in.readString();
            publisher = in.readString();
            alignment = in.readString();
        }

        public static final Creator<Biography> CREATOR = new Creator<Biography>() {
            @Override
            public Biography createFromParcel(Parcel in) {
                return new Biography(in);
            }

            @Override
            public Biography[] newArray(int size) {
                return new Biography[size];
            }
        };

        public String getFullName() {
            return fullName;
        }

        public String getAlterEgos() {
            return alterEgos;
        }

        public List<String> getAliases() {
            return aliases;
        }

        public String getPlaceOfBirth() {
            return placeOfBirth;
        }

        public String getFirstAppearance() {
            return firstAppearance;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getAlignment() {
            return alignment;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(fullName);
            dest.writeString(alterEgos);
            dest.writeStringList(aliases);
            dest.writeString(placeOfBirth);
            dest.writeString(firstAppearance);
            dest.writeString(publisher);
            dest.writeString(alignment);
        }
    }

    public static class Work implements Parcelable{
        @SerializedName("occupation")
        @Expose
        private String occupation;
        @SerializedName("base")
        @Expose
        private String base;

        protected Work(Parcel in) {
            occupation = in.readString();
            base = in.readString();
        }

        public static final Creator<Work> CREATOR = new Creator<Work>() {
            @Override
            public Work createFromParcel(Parcel in) {
                return new Work(in);
            }

            @Override
            public Work[] newArray(int size) {
                return new Work[size];
            }
        };

        public String getOccupation() {
            return occupation;
        }

        public String getBase() {
            return base;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(occupation);
            dest.writeString(base);
        }
    }
    public static class Connections implements Parcelable{


        @SerializedName("groupAffiliation")
        @Expose
        private String groupAffiliation;
        @SerializedName("relatives")
        @Expose
        private String relatives;

        protected Connections(Parcel in) {
            groupAffiliation = in.readString();
            relatives = in.readString();
        }

        public static final Creator<Connections> CREATOR = new Creator<Connections>() {
            @Override
            public Connections createFromParcel(Parcel in) {
                return new Connections(in);
            }

            @Override
            public Connections[] newArray(int size) {
                return new Connections[size];
            }
        };

        public String getGroupAffiliation() {
            return groupAffiliation;
        }

        public String getRelatives() {
            return relatives;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(groupAffiliation);
            dest.writeString(relatives);
        }
    }
    public static class mImages implements Parcelable{
        @SerializedName("xs")
        @Expose
        private String xs;
        @SerializedName("sm")
        @Expose
        private String sm;
        @SerializedName("md")
        @Expose
        private String md;
        @SerializedName("lg")
        @Expose
        private String lg;

        protected mImages(Parcel in) {
            xs = in.readString();
            sm = in.readString();
            md = in.readString();
            lg = in.readString();
        }

        public static final Creator<mImages> CREATOR = new Creator<mImages>() {
            @Override
            public mImages createFromParcel(Parcel in) {
                return new mImages(in);
            }

            @Override
            public mImages[] newArray(int size) {
                return new mImages[size];
            }
        };

        public String getXs() {
            return xs;
        }

        public String getSm() {
            return sm;
        }

        public String getMd() {
            return md;
        }

        public String getLg() {
            return lg;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(xs);
            dest.writeString(sm);
            dest.writeString(md);
            dest.writeString(lg);
        }
    }




}
