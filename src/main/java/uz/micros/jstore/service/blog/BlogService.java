package uz.micros.jstore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Blog;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.repository.PostRepository;
import uz.micros.jstore.util.DBManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private PostRepository postRepository;

    public Blog getBlog(){
        Blog blog = new Blog();
        blog.setTitle("jStore Corporate Blog!!!");

        List<Post> posts = postRepository.getPosts();

        /*for(int k = 0; k < 3; k++){

            Post post = new Post();
            post.setId(k + 100);
            post.setSubject("Post " + (k + 1));
            post.setDate(new Date());
            post.setText("«Газпром» с ноября по сегодня предоставил счета, но платежей не было. Цифры растут в последние месяцы, и сейчас мы смотрим на счет примерно в $4 млрд», — сказал Эттингер на пресс-конференции.\n" +
                    "\n" +
                    "По его словам, Еврокомиссия заинтересована в том, чтобы спор между Россией и Украиной по цене на газ был разрешен в ближайшее время.\n" +
                    "\n" +
                    "«По ряду причин это в наших интересах, чтобы этот конфликт был разрешен быстро», — приводит слова еврокомиссара «РИА Новости».\n" +
                    "\n" +
                    "Эттингер также отметил, что считает $268,5 за 1 тыс. куб. м российского газа очень низкой ценой, а $485 — очень высокой. Подходящей, по словам еврокомиссара, для оплаты российского газа для Украины станет «цена в размере между $200 и $400».\n" +
                    "\n" +
                    "В понедельник после пятичасовых переговоров в Берлине по газовому вопросу России удалось добиться обещания от украинской стороны начать платить по своим долгам. По словам главы Минэнерго РФ Александра Новака, Россия готова продолжить переговоры о цене поставляемого на Украину газа, если Украина перечислит «Газпрому» $2,5 млрд в счет части оплаты долга. По словам источника «Известий», присутствовавшего на переговорах от российской стороны, $2 млрд украинская сторона пообещала перевести российской до конца этой недели, а еще $500 млн — до 7 июня.\n"
                    );

            posts.add(post);
        }*/

        blog.setPosts(posts);

        return blog;
    }
}
