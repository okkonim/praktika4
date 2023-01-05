import java.util.Random;

public class Worker {
    private String name;
    private String surname;
    private int age;
    private String sex;
    private String cat;
    private String department;
    private String post;
    private int salary;
    private int premium;
    private int workExperience;

    private final String[] sexes = {"мужской", "женский"};

    private final String[] maleNames = {"Александр", "Евгений", "Степан"};
    private final String[] femaleNames = {"Ольга", "Юлия", "Анна"};

    private final String[] maleSurnames = {"Иванов", "Васильев", "Никоноров"};
    private final String[] femaleSurnames = {"Иванова", "Васильева", "Никонорова"};


    private final String[] namesOfCats = {"Эрик", "Джес", "Томас",
            "Хисс", "Вася", "Тэля", null};
    private final String[] departments = {"Экономический отдел", "Юридический отдел", "Имущественный отдел"};
    private final String[] posts = {"Руководитель", "Ведущий специалист", "Специалист"};

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Worker() {
        Random random = new Random();
        this.setSex(sexes[random.nextInt(2)]);
        if (getSex().equals("мужской")) {
            this.setName(maleNames[random.nextInt(3)]);
            this.setSurname(maleSurnames[random.nextInt(3)]);
        } else {
            this.setName(femaleNames[random.nextInt(3)]);
            this.setSurname(femaleSurnames[random.nextInt(3)]);
        }
        this.setSalary(random.nextInt(15 ,100) * 1000);
        this.setAge(random.nextInt(18,70));
        if (random.nextInt(2)==1) {
            this.setPremium(random.nextInt(10000));
        }
        else this.setPremium(0);
        this.setWorkExperience(random.nextInt(10));
        this.setDepartment(departments[random.nextInt(3)]);
        this.setPost(posts[random.nextInt(3)]);
        this.setCat(namesOfCats[random.nextInt(7)]);


    }
}