package com.acme.todolist;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.acme.todolist.domain.TodoItem;//Import du package TodoItem

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void createdTodoItem()
	{
		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d31", Instant.now(), "todoItem 0f8-06eb17ba8d31 : créé (method=createdTodoItem) \n Maintenant");
		assertFalse(todoItem.finalContent().contains("[LATE!] "));
	}
	
	@Test
	void created24HAgoTodoItem() {
		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d32", Instant.now().minus(24,ChronoUnit.HOURS), "todoItem 0f8-06eb17ba8d32 : créé (method=created24HAgoTodoItem) \n Il y a 24H");
		assertFalse(todoItem.finalContent().contains("[LATE!] "));
	}
	
	@Test
	void createdADayAgoTodoItem() {
		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d33", Instant.now().minus(1,ChronoUnit.DAYS), "todoItem 0f8-06eb17ba8d33 : créé (method=createdADayAgoTodoItem) \n Il y a un jour");
		assertFalse(todoItem.finalContent().contains("[LATE!] "));
	}
}
