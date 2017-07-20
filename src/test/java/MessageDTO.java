import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/7/9 ProjectName: coding-myself Version: 1.0
 */

public class MessageDTO implements Delayed{

    private String loginName;

    private String mobile;

    /**
     * 到期时间 nanoTime
     */
    private long expireTime ;


    /**
     *
     * @param loginName
     * @param mobile
     * @param timeout 超时时间
     */
    public MessageDTO(String loginName, String mobile,long timeout,TimeUnit unit) {
        this.loginName = loginName;
        this.mobile = mobile;
        this.expireTime = System.nanoTime() + unit.toNanos(timeout);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime - System.nanoTime() ,unit);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) // compare zero if same object
            return 0;
        if( other instanceof MessageDTO){
            MessageDTO x = (MessageDTO) other;
            long diff = expireTime - x.expireTime;
            if (diff < 0)
                return -1;
            else if (diff > 0)
                return 1;
            else
                return 0;
        }
        long diff = getDelay(NANOSECONDS) - other.getDelay(NANOSECONDS);
        return  (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDTO that = (MessageDTO) o;
        return  Objects.equals(loginName, that.loginName) &&
                Objects.equals(mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName, mobile);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageDTO{");
        sb.append("loginName='").append(loginName).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", expireTime=").append(expireTime);
        sb.append('}');
        return sb.toString();
    }
}
