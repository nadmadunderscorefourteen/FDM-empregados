package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Department dep;
		int n;

		System.out.print("Nome do departamento: ");
		String dptoName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payD = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();

		dep = new Department(dptoName, payD, new Address(email, phone));

		System.out.print("Quantos funcionários tem no departamento? ");
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do funcioário " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			dep.addEmployee(new Employee(name, salary));
		}
		
		showReport(dep);

		sc.close();
	}

	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.printf("Departamento %s = R$ %.2f\n", dept.getName(), dept.payroll());
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários:");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para dúvidas, favor entrar em contato: " + dept.getAddress().getEmail());
	}
}