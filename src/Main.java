import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            workers.add(new Worker());
        }
        Optional<Worker> maxSalaryWorker = workers.stream().max(Comparator.comparing(Worker::getSalary));
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalaryWorker.get().getName() + " " + maxSalaryWorker.get().getSurname() + ": " + maxSalaryWorker.get().getSalary());

        Optional<Worker> minSalaryWorker = workers.stream().min(Comparator.comparing(Worker::getSalary));
        System.out.println("Сотрудник с минимальной зарплатой - " + minSalaryWorker.get().getName() + " " + minSalaryWorker.get().getSurname() + ": " + minSalaryWorker.get().getSalary());

        Stream<Worker> filter1 = workers.stream()
                .sorted(Comparator.comparing(Worker::getAge))
                .filter(worker -> worker.getAge() < 50)
                .filter(worker -> worker.getCat() != null);
        List<Worker> work1 = filter1.toList();
        System.out.print("Люди с котами младше 50 - ");
        for (Worker value : work1) {
            System.out.print(value.getName() + " " + value.getSurname() + " ,");
        }

        Stream<Worker> filter2 = workers.stream()
                .sorted(Comparator.comparing(Worker::getAge))
                .filter(worker -> worker.getAge() > 50)
                .filter(worker -> worker.getCat() != null);
        List<Worker> work2 = filter2.toList();
        System.out.print("\nЛюди с котами старше 50 - ");
        for (Worker value : work2) {
            System.out.print(value.getName() + " " + value.getSurname() + " ,");
        }

        Supplier<Stream<Worker>> filter3 = () -> workers.stream()
                .filter(worker -> worker.getDepartment().equals("Экономический отдел"));
        filter3.get().forEach(worker -> worker.setPremium(worker.getPremium() * 2));
        List<Worker> work3 = filter3.get().toList();
        System.out.print("\nЛюди, удвоившие премию - ");
        for (Worker value : work3) {
            System.out.print(value.getName() + " " + value.getSurname() + " ,");
        }

        Supplier<Stream<Worker>> salary100k = () -> workers.stream()
                .filter(worker -> worker.getPremium() + worker.getSalary() > 100000);
        if (salary100k.get().findFirst().isPresent()) {
            Optional<Worker> sheih = salary100k.get().findFirst();
            int endSalary = sheih.get().getSalary() + sheih.get().getPremium();
            System.out.println("\nЗарплата у " + sheih.get().getName() + " " + sheih.get().getSurname() + " " + endSalary + "$ в наносекунду");
        } else {
            System.out.println("\nКомпания нищебродов...\n");
        }

       /* Map<String, List<Worker>> workersByDepartments = workers.stream().collect(
                Collectors.groupingBy(Worker::getDepartment));

        for( Map.Entry<String, List<Worker>> worker : workersByDepartments.entrySet()){
            System.out.println( "\n"+worker.getKey());
            for( Worker worker1: worker.getValue()){
                System.out.println(worker1.getName() +" " +worker1.getSurname());

            }

        }*/

        long filter5 = workers.stream()
                .filter(worker -> worker.getDepartment().equals("Экономический отдел"))
                .count();

        long filter6 = workers.stream()
                .filter(worker -> worker.getDepartment().equals("Юридический отдел"))
                .count();

        long filter7 = workers.stream()
                .filter(worker -> worker.getDepartment().equals("Имущественный отдел"))
                .count();

        System.out.printf("%-25s%-25s%-25s%n", "Экономический отдел", "Юридический отдел", "Имущественный отдел");
        System.out.printf("%-25s%-25s%-25s%n", filter5, filter6, filter7);


    }
}