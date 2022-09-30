const URL_API = "http://localhost:8080/userdata"
async function data_login(evt) {
    // Indicar por medio del evento que no recargue página
    evt.preventDefault()

    const form = evt.target
    const userlog = {
        team: form.team.value,
        userName: form.user_name.value,
        password: form.password.value,
    }
    
    await valid_login(userlog)
    clear(form)
    
}


async function valid_login(userlog) {

    const resp = await fetch(`${URL_API}/login/${userlog.userName}`)

    let dataUser = await resp.json()

    //console.log(dataUser)
    if (dataUser.userName == userlog.userName) {
        if (dataUser.team == userlog.team) {
            if (dataUser.password == userlog.password) {
                console.log(dataUser);
                //Llevar a la vista de la agenda
                localStorage.setItem('id', dataUser.id);
                localStorage.setItem('userName', dataUser.userName);
                localStorage.setItem('admin', dataUser.teamAdmin);
                localStorage.setItem('team', dataUser.team);
                window.location.href = `/Agenda.html`
            } else {
                alert("Incorrect user data")
            }
        } else {
            alert("Incorrect user data")
        }
    } else {
        alert("Incorrect user data")
    }
}

function clear(form) {
    form.team.value = ""
    form.user_name.value = ""
    form.password.value = ""
}

