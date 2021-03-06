package com.example.moviecatalogue.utils



import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowsResponse
import java.util.*

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {

        val courses = ArrayList<MoviesEntity>()

        courses.add(
            MoviesEntity("1",
                "A Star Is Born",
                "2018",
                "05/10/2018",
                "Drama, Percintaan, Musik",
                "2h 16m",
                "75%",
                "",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )
        courses.add(
            MoviesEntity("2",
                "Alita: Battle Angel",
                "2019",
                "14/02/2019",
                "Aksi, Cerita Fiksi, Petualangan",
                "2h 2m",
                "72%",
                "An angel falls. A warrior rises.",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )
        courses.add(
            MoviesEntity("3",
                "Aquaman",
                "2018",
                "21/12/2018",
                "Aksi, Petualangan, Fantasi",
                "2h 23m",
                "69%",
                "Home Is Calling",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )
        courses.add(
            MoviesEntity("4",
                "Bohemian Rhapsody",
                "2018",
                "02/11/2018",
                "Musik, Drama, Sejarah",
                "2h 15m",
                "80%",
                "Fearless lives forever",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet ??? finding a way to keep the band together amid the success and excess.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )
        courses.add(
            MoviesEntity("5",
                "Cold Pursuit",
                "2019",
                "08/02/2019",
                "Aksi, Kejahatan, Cerita Seru",
                "1h 59m",
                "56%",
                "Meet Nels Coxman. Citizen of the Year.",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )
        courses.add(
            MoviesEntity("6",
                "Creed II",
                "2018",
                "21/11/2018",
                "Drama",
                "2h 10m",
                "69%",
                "There's More to Lose than a Title",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )
        courses.add(
            MoviesEntity("7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "11/16/2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "69%",
                "Fate of One. Future of All.",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause???elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg")
        )
        courses.add(
            MoviesEntity("8",
                "Glass",
                "2019",
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "67%",
                "You Cannot Contain What You Are",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )
        courses.add(
            MoviesEntity("9",
                "Bohemian Rhapsody",
                "2018",
                "02/11/2018",
                "Musik, Drama, Sejarah",
                "2h 15m",
                "80%",
                "Fearless lives forever",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet ??? finding a way to keep the band together amid the success and excess.",
                false,
                "https://www.themoviedb.org/t/p/original/ff4FqoBuetUxZSBrR4hXp7IOc59.jpg")
        )
        courses.add(
            MoviesEntity("10",
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "02/22/2019",
                "Animation, Family, Adventure",
                "1h 44m",
                "78%",
                "The friendship of a lifetime",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless??? discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup???s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg")
        )

        return courses
    }

    fun generateDummyTvShows(): List<TvShowsEntity> {

        val courses = ArrayList<TvShowsEntity>()

        courses.add(
            TvShowsEntity("1",
            "Arrow",
            "Crime, Drama, Mystery, Action & Adventure",
            "42m",
                "66%",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )
        courses.add(
            TvShowsEntity("2",
            "Doom Patrol",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
                "49m",
                "76%",
                "The Doom Patrol???s members each suffered horrible accidents that gave them superhuman abilities ??? but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence ??? and to protect Earth from what they find.",
                "2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )
        courses.add(
            TvShowsEntity("3",
            "Dragon Ball",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "25m",
                "81%",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )
        courses.add(
            TvShowsEntity("4",
            "Fairy Tail",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "25m",
                "77%",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "2009",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg")
        )
        courses.add(
            TvShowsEntity("5",
                "Family Guy",
                "Animation, Comedy",
                "22m",
                "69%",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg")
        )
        courses.add(
            TvShowsEntity("6",
                "The Flash",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "76%",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )
        courses.add(
            TvShowsEntity("7",
                "Naruto Shipp??den",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                "86%",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg")
        )
        courses.add(
            TvShowsEntity("8",
                "NCIS",
                "Kejahatan, Aksi & Petualangan, Drama",
                "45m",
                "74%",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "2003",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg")
        )
        courses.add(
            TvShowsEntity("9",
                "The Simpsons",
                "Family, Animation, Comedy",
                "22m",
                "78%",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg")
        )
        courses.add(
            TvShowsEntity("10",
                "Supergirl",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "42m",
                "72%",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg")
        )

        return courses
    }

    fun generateDummyMoviesResponse(): List<MovieResponse> {

        val courses = ArrayList<MovieResponse>()

        courses.add(
            MovieResponse("1",
            "A Star Is Born",
            "2018",
            "05/10/2018",
            "Drama, Percintaan, Musik",
            "2h 16m",
            "75%",
            "",
            "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )
        courses.add(
            MovieResponse("2",
            "Alita: Battle Angel",
            "2019",
            "14/02/2019",
            "Aksi, Cerita Fiksi, Petualangan",
            "2h 2m",
            "72%",
            "An angel falls. A warrior rises.",
            "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )
        courses.add(
            MovieResponse("3",
            "Aquaman",
            "2018",
            "21/12/2018",
            "Aksi, Petualangan, Fantasi",
            "2h 23m",
            "69%",
            "Home Is Calling",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )
        courses.add(
            MovieResponse("4",
            "Bohemian Rhapsody",
            "2018",
            "02/11/2018",
            "Musik, Drama, Sejarah",
            "2h 15m",
            "80%",
            "Fearless lives forever",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet ??? finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )
        courses.add(
            MovieResponse("5",
            "Cold Pursuit",
            "2019",
            "08/02/2019",
            "Aksi, Kejahatan, Cerita Seru",
            "1h 59m",
            "56%",
            "Meet Nels Coxman. Citizen of the Year.",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )
        courses.add(
            MovieResponse("6",
            "Creed II",
            "2018",
            "21/11/2018",
            "Drama",
            "2h 10m",
            "69%",
            "There's More to Lose than a Title",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )
        courses.add(
            MovieResponse("7",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "2018",
            "11/16/2018",
            "Adventure, Fantasy, Drama",
            "2h 14m",
            "69%",
            "Fate of One. Future of All.",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause???elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg")
        )
        courses.add(
            MovieResponse("8",
            "Glass",
            "2019",
            "01/18/2019",
            "Thriller, Drama, Science Fiction",
            "2h 9m",
            "67%",
            "You Cannot Contain What You Are",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )
        courses.add(
            MovieResponse("9",
            "Bohemian Rhapsody",
            "2018",
            "02/11/2018",
            "Musik, Drama, Sejarah",
            "2h 15m",
            "80%",
            "Fearless lives forever",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet ??? finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/original/ff4FqoBuetUxZSBrR4hXp7IOc59.jpg")
        )
        courses.add(
            MovieResponse("10",
            "How to Train Your Dragon: The Hidden World",
            "2019",
            "02/22/2019",
            "Animation, Family, Adventure",
            "1h 44m",
            "78%",
            "The friendship of a lifetime",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless??? discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup???s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg")
        )

        return courses
    }

    fun generateDummyTvShowsResponse(): List<TvShowsResponse> {

        val courses = ArrayList<TvShowsResponse>()

        courses.add(
            TvShowsResponse("1",
            "Arrow",
            "Crime, Drama, Mystery, Action & Adventure",
            "42m",
            "66%",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "2012",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )
        courses.add(
            TvShowsResponse("2",
            "Doom Patrol",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
            "49m",
            "76%",
            "The Doom Patrol???s members each suffered horrible accidents that gave them superhuman abilities ??? but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence ??? and to protect Earth from what they find.",
            "2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )
        courses.add(
            TvShowsResponse("3",
            "Dragon Ball",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "25m",
            "81%",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "1986",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )
        courses.add(
            TvShowsResponse("4",
            "Fairy Tail",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
            "25m",
            "77%",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "2009",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg")
        )
        courses.add(
            TvShowsResponse("5",
            "Family Guy",
            "Animation, Comedy",
            "22m",
            "69%",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "1999",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg")
        )
        courses.add(
            TvShowsResponse("6",
            "The Flash",
            "Drama, Sci-Fi & Fantasy",
            "44m",
            "76%",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "2014",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )
        courses.add(
            TvShowsResponse("7",
            "Naruto Shipp??den",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "25m",
            "86%",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "2007",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg")
        )
        courses.add(
            TvShowsResponse("8",
            "NCIS",
            "Kejahatan, Aksi & Petualangan, Drama",
            "45m",
            "74%",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "2003",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg")
        )
        courses.add(
            TvShowsResponse("9",
            "The Simpsons",
            "Family, Animation, Comedy",
            "22m",
            "78%",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "1989",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg")
        )
        courses.add(
            TvShowsResponse("10",
            "Supergirl",
            "Drama, Sci-Fi & Fantasy, Action & Adventure",
            "42m",
            "72%",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "2015",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg")
        )

        return courses
    }
}
