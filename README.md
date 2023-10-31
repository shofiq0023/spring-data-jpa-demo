# Data relation with JPA mapping
This is a demonstration project for data mapping with Spring data JPA.

### Some pointers of this project:
- There is no authentication in this project as this is a demo project.
- This project demonstrate the JPA Mapping like One-to-One, Many-to-One, Many-to-Many mapping.

# One-to-One Mapping:
This mapping is where one entity with directly related with exactly one another entity. This is demonstrated by the **User** and **UserPersonalInfo** entity in the project.  
In the **User** entity the **@OneToOne** annotation is used for the mapping. Cascade type is set to **ALL** for reflecting any changes made to the **User** entity.
```java
// Entity class
public class User {
	// Other properties

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personal_info_id", referencedColumn = "id")
	private UserPersonalInfo personalInfo;

	// Getters and setters
}
```
**@JoinColumn** annotation is used on the owning side of the relation. In My case **User** is the owning side. **@JoinColumn** is not necessary but for controll I included the annotation. This annotation defines the relation by using the other entity's "id".  
  
On the other hand, for the **UserPersonalInfo** entity, I added the **@OneToOne** and **@JsonBackReference** annotation.
```java
// Entity class
public class UserPersonalInfo {
	// Other properties

	@OneToOne(mappedBy = "personalInfo")
	@JsonBackReference
	private User user;

	// Getters and setters
}
```
Here the **@JsonBackReference** was used to avoid **Jackson data bind loop error**. This annotation is required if you want to return the entity class in response. I would suggest using a DTO for API response. I returned the entity class for the sake of this demonstration.

# One-to-Many Mapping:
This mapping is where one entity is related to multiple other entities. This is the most commonly used relationship. This is demonstrated by the **Book** and **Author** entity in this project.  
In this case the Book is the owning side of this relationship.  
```java
// Entity class
public class Book {
	@ManyToOne
	@JoinColumn(name = "author_id")
	@JsonBackReference
	private Author author;
}

// Entity class
public class Author {
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books;
}
```
Here the relationship is Unidirectional as we have specified the owning and reverse side of the relationship.