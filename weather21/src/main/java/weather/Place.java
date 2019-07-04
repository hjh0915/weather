package weather;

class Place {
    int _id;
    int id;
    int pid;
    String city_code;
    String city_name;

    @Override
    public String toString() {
        return "city_code:" + this.city_code + " " + "city_name:" + this.city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public String getCitycode() {
        return city_code;
    }

    public void setCitycode(String city_code) {
        this.city_code = city_code;
    }

    public String getCityname() {
        return city_name;
    }

    public void setCityname(String city_name) {
        this.city_name = city_name;
    }
}