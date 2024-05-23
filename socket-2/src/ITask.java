import java.io.Serializable;

public interface ITask extends Serializable {
    void setExecNumber(int x);
    void exec();
    int getResult();
}
