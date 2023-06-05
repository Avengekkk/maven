package CLASS;

public class stu {

    public Integer id;
    public String gender;
    public String name;
    public String birthday;
    public Integer score;
    public String email;
    public String phone;
    public Integer status;


    public stu() {
    }

    public stu(int id, String gender, String name, String birthday, int score, String email, String phone, int status) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.score = score;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public String toString() {
        return "stu{id = " + id + ", gender = " + gender + ", name = " + name + ", birthday = " + birthday + ", score = " + score + ", email = " + email + ", phone = " + phone + ", status = " + status + "}";
    }
}
