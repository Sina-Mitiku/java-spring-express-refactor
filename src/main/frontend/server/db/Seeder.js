import pg from "pg"

const pool = new pg.Pool({
  connectionString: "postgres://postgres:password@localhost:5432/adopt_a_pet"
})


class Seeder {
  static async seed() {
   try {
         await pool.query(
           "INSERT INTO pet_types (type, img_url, description) VALUES ('Dog','https://static.onecms.io/wp-content/uploads/sites/24/2020/03/GettyImages-73032606-2000.jpg','Best friends'),('Cats', 'https://cvillecatcare.com/wp-content/uploads/2018/07/cat-175997-300x200.jpg', 'Cute and loving');"
         )
         await pool.query(
           "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Bean','https://www.dogtime.com/assets/uploads/2011/01/file_23228_mutt-460x290.jpg', 3, true, 'Bean was rescued from street.', 'available', 1);"
         )
         await pool.query(
           "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Bella', 'https://live.staticflickr.com/2518/4211133172_daca464ea4_b.jpg', 1, false, 'Bella was surrendered by previous owners.', 'available', 2);"
         )
         await pool.query(
           "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Kitty', 'https://pbs.twimg.com/profile_images/875624659357581314/FCZGd6pr_400x400.jpg', 2, true, 'Kitty is rescued from around a train station.', 'available', 2);"
         )
         await pool.query(
           "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Bailey', 'https://thepetridish.my/wp-content/uploads/2020/03/doggo.jpg', 4, false, 'Bailey was surrendered', 'available', 1);"
         )
      pool.end()
    } catch (error) {
      console.error(error)
      pool.end()
    }
  }
}

export default Seeder
