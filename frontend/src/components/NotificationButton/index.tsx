import notification_icon from '../../assets/images/notification-icon.svg';

import './styles.css';
import axios from "axios";
import {BASE_URL} from "../../utils/request";
import {toast} from "react-toastify";

type Props = {
    saleId: number;
}

function handleClick(id: number) {
    axios(`${BASE_URL}/sales/${id}/notifications`).then(() => {
        toast.info("Message sent successfully")
    })
}

function NotificationButton({saleId}: Props) {

    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={notification_icon} alt="Notification Button"/>
        </div>
    )
}

export default NotificationButton;