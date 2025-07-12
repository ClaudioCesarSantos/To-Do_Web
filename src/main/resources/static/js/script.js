function addTask() {
    const input = document.getElementById('taskInput');
    const taskText = input.value.trim();

    if (taskText !== "") {
        fetch("/tarefas", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "descricao=" + encodeURIComponent(taskText)
        }).then(response => {
            if (response.redirected) {
                window.location.href = response.url;
            }
        });
    }
}
