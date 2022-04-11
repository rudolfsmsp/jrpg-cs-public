package Character_Classes

class Character_Party (var party: List[Character]){

  def kill_enemy_party(enemy_party: Character_Party): Unit = {

    var members: Int = 0

    for (group <- this.party) {

      if (group.character_death_status == false) {

         members += 1

      }

    }

    for (enemy_character <- enemy_party.party){

      for (group <- this.party){

        if(group.character_death_status == false) {

          var earned_team_experience: Int = 50 / members

          group.gainedExperience(earned_team_experience)

        }

      }

    }

  }

}
