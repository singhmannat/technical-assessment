import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CodeToRefactor {
    
    public static class People {
        private static final OffsetDateTime Under16 = OffsetDateTime.now().minusYears(15);

        private String name;
        private OffsetDateTime dob;

        public People(String name)
        {
            this(name, Under16.toLocalDateTime());
        }

        public People(String name, LocalDateTime dob) {
            this.name = name;
            this.dob = dob.atOffset(OffsetDateTime.now().getOffset());
        }

        public String getName() 
        {
            return name;
        }

        public OffsetDateTime getDob() {
            return dob;
        }
    }

    public static class BirthingUnit
    {
        /**
         * MaxItemsToRetrieve
         */
        private List<People> people;

        public BirthingUnit() {
            people = new ArrayList<>();
        }

        /**
         * GetPeoples
         * @param j
         * @return List<Object>
         */
        public List<People> getPeople(int i)
        {
					//MS:28/03/2026: use constants
					final int MIN_AGE = 18;
					final int MAX_AGE = 85;
					final int DAYS_IN_YEAR = 365;
					
					Random random = new Random(); //MS:28/03/2026: moved out of for loop
					
            for (int j = 0; j < i; j++) {
                try 
                {
									/*
                    // Creates a dandon Name
                    String name = "";
                    Random random = new Random();
                    if (random.nextInt(1) == 0) {
                        name = "Bob";
                    } else { name = "Betty"; }
                    // Adds new people to the list
                    people.add(new People(name, LocalDateTime.now().minusDays(random.nextInt(18, 85) * 356)));
								*/
								
									//MS:28/03/2026: would prefer generating based on random boolean if it has to be split among Bob and Betty only. 
																	 // or nextInt(2) can also be used
									String name = random.nextBoolean() ? "Bob" : "Betty";
									
									people.add(new People(name, LocalDateTime.now().minusDays(random.nextInt(MIN_AGE, MAX_AGE) * DAYS_IN_YEAR)));
                } 
                catch (Exception e)
                {
                    // Dont think this should ever happen
                    throw new RuntimeException("Something failed in user creation");
                }
            }
            return people;
        }

        private List<People> getBobs(boolean olderThan30) {
					
					/* MS:28/03/2026: -- changed to "Bob".equals(x.getName()) to avoid a possible null pointer exception
														-- updated to getDob() instead of getDOB()
             								-- replaced with correct number of year days as 365 instead of 356
														-- removed the negation operator ! so that it aligns with what is expected from this method
					  */
            return olderThan30 ? people.stream().filter(x -> "Bob".equals(x.getName()) && x.getDob().isBefore(LocalDateTime.now().minus(Duration.ofDays(30 * 365)))).collect(Collectors.toList()) : people.stream().filter(x -> "Bob".equals(x.getName())).collect(Collectors.toList());
        }

        public String getMarried(People p, String lastName)
        {
            if (lastName.toLowerCase().contains("test")) //MS:28/03/2026: changed to case insensitive
                return p.getName();
					/*
            if ((p.getName().length() + lastName).length() > 255) {
                (p.getName() + " " + lastName).substring(0, 255);
            }

            return p.getName() + " " + lastName;
					*/
						
						//MS:28/03/2026: first store and then return name with upto 255 limit
            String fullName = p.getName() + " " + lastName;
            return fullName.length() > 255 ? fullName.substring(0, 255) : fullName;
        }
    }
}
