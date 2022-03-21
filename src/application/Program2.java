package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();		
		
		System.out.println("*** TEST 1: Department findById ***");
		Department dep = departmentDao.findById(1);		
		System.out.println(dep);
		
		System.out.println("\n*** TEST 2: Department findByAll ***");		
	    List<Department> lista = departmentDao.findAll();
		for (Department obj: lista) {
			System.out.println(obj);
		}
		
		System.out.println("\n*** TEST 3: Department insert ***");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo Id = " + newDepartment.getId());
		
		System.out.println("\n*** TEST 4: Department update ***");
		dep = departmentDao.findById(1);
		dep.setNome("Food");
		departmentDao.update(dep);
		System.out.println("Update Concluído!");
		
		System.out.println("\n*** TEST 5: Department delete ***");
		System.out.print("Entre com um Id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Concluído!");
		
		sc.close();

	}

}
