package org.launchcode.MyBeat.models.data;


import org.launchcode.MyBeat.models.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Data Access Object - interface to access story classes
// to and from the database. Store story objects and the keys are
// integers.

// Tell Spring this interface is a repository it needs to handle
@Repository
// Specify that all of the methods in this interface should be
// wrapped by database transaction
@Transactional
public interface StoryDao extends CrudRepository<Story, Integer> {
}
