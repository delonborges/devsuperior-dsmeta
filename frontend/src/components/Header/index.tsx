import github_logo from '../../assets/images/github.svg'
import logo from '../../assets/images/logo.svg'

import './styles.css'

function Header() {
    return (
        <div className="dsmeta-logo-container">
            <img src={logo} alt="DSMeta Project Logo"/>
            <h1>DSMeta</h1>
            <a href="https://github.com/delonborges" target="_blank" rel="noreferrer">
                <img src={github_logo} alt="GitHub Logo"/>
                <p>/delonborges</p>
            </a>
        </div>
    )
}

export default Header
