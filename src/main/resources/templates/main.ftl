<html>
<head>
    <title>Welcome!</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.5.0/knockout-min.js"></script>
    <style>
        body {
            font-size: 20px;
        }
    </style>
</head>
<body>
<h1>

</h1>

    <script type="text/html" id="library">

        <div data-bind="style: { 'margin-left': (level * 20) + 'px', 'margin-bottom': '10px'}">
            <span data-bind="text: name"></span>
            <button style="float: right; margin-left: 10px" data-bind="click: $root.addSub">Add</button>
            <button style="float: right" data-bind="click: $root.delete">Delete</button>
        </div>

            <!-- ko template: { name: 'library',
                    foreach: subFolders, templateOptions: {level: level + 1} } -->
            <!-- /ko -->

    </script>
<div style="width: 700px; margin: 30px 0 0 30px" data-bind="template: {name : 'library', foreach: $root.folders, templateOptions: {level: 0}}"></div>

<script>
    function AppViewModel() {
        const local = this;
        this.folders = ko.observableArray([]);
        $.ajax({
            url: '/api/folders',
            success: (data) => {
                local.folders(data)
            }
        });
        local.delete = (item) => {
            $.ajax({
                url: '/api/folders/' + item.id,
                type: 'DELETE',
                success: (data) => {
                    window.location.reload(false);
                }
            })
        }
        local.addSub = (item) => {
            const name = window.prompt("Do you want to create subfolder for " + item.name + "? Enter name:");
            $.ajax({
                url: '/api/folders',
                type: 'POST',
                data: JSON.stringify({ name : name, parentFolderId: item.id }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: (data) => {
                    window.location.reload(false);
                }
            })
        }
    }
    ko.applyBindings(new AppViewModel());
</script>
</body>
</html>