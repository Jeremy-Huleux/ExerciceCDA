import { useEffect, useRef, useState } from "react";

import styles from "./ClockPage.module.css";

/**
 * Page présentant une horloge interactive
 */
const ClockPage = () => {

    // TODO déclarer un state permettant de stocker la date et l'heure actuelle
    // Indice sur ce qu'il faudrait stocker : https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Date
    const [horloge, setHorloge] = useState<Date>(new Date());
    const interval = useRef<number | null>(null);

    useEffect(() => {
    }, []);

    /**
     * TODO fonction permettant de démarrer l'horloge
     */
    function handleStartClick() {
        interval.current = setInterval(() => {
            setHorloge(() => new Date());
        },1000);
    }

        
    /**
     * TODO fonction permettant de stopper l'horloge
     */
    function handleStopClick(){
        if(interval.current != undefined){
            clearInterval(interval.current);
            setHorloge(() => new Date());
        }
    }

    return (
        <div className={styles.clockContainer}>
            <button onClick={handleStartClick}>start</button>
            <button onClick={handleStopClick}>arret</button>
            <p>{horloge.getHours()} : {horloge.getMinutes()} : {horloge.getSeconds()}</p>
            {/* TODO implémenter l'interface graphique de l'horloge */}
        </div>
    );
}

export default ClockPage;