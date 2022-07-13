import notification_icon from '../../assets/images/notification-icon.svg';

import './styles.css';

function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={notification_icon} alt="Notification Button"/>
        </div>
    )
}

export default NotificationButton;