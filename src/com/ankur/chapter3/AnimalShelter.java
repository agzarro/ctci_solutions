package com.ankur.chapter3;

import java.util.Date;
import java.util.LinkedList;

public class AnimalShelter {
	
	public static void main(String[] args) throws InterruptedException {
		
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Animal(AnimalType.DOG));
		Thread.sleep(10);
		shelter.enqueue(new Animal(AnimalType.CAT));
		Thread.sleep(10);
		shelter.enqueue(new Animal(AnimalType.CAT));
		Thread.sleep(10);
		shelter.enqueue(new Animal(AnimalType.CAT));
		Thread.sleep(10);
		shelter.enqueue(new Animal(AnimalType.DOG));
		Thread.sleep(10);
		shelter.enqueue(new Animal(AnimalType.DOG));
		Thread.sleep(10);
		System.out.println(shelter.dequeueCat().type);
		System.out.println(shelter.dequeueAny().type);
		System.out.println(shelter.dequeueAny().type);
		System.out.println(shelter.dequeueAny().type);
		System.out.println(shelter.dequeueAny().type);
		System.out.println(shelter.dequeueAny().type);		
		
	}
	
	private LinkedList<Animal> dogs = new LinkedList<>();
	private LinkedList<Animal> cats = new LinkedList<>();

	
	public enum AnimalType {
		CAT,
		DOG
	}
	
	public static class Animal {
		private AnimalType type;
		private Date shelterDate;
		
		public Animal(AnimalType type) {
			this.type = type;
			this.shelterDate = new Date(System.currentTimeMillis());
		}
	}
	
	
	public void enqueue(Animal animal) {
		if(animal.type == AnimalType.DOG) {
			dogs.add(animal);
		} else {
			cats.add(animal);
		}
	}
	
	public Animal dequeueAny() {
		if(dogs.isEmpty()) {
			return cats.getFirst();
		}
		if(cats.isEmpty()) {
			return dogs.getFirst();
		}
		if (dogs.getFirst().shelterDate.before(cats.getFirst().shelterDate)) {
			return dogs.removeFirst();
		} else {
		 return cats.removeFirst();
		}
	}
	
	public Animal dequeueDog() {
		return dogs.removeFirst();
	}
	
	public Animal dequeueCat() {		
		
		return cats.removeFirst();
	}
	
	
	

}
